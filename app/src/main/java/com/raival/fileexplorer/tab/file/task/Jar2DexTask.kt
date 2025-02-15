package com.raival.fileexplorer.tab.file.task

import android.os.Handler
import android.os.Looper
import com.android.tools.r8.CompilationMode
import com.android.tools.r8.D8
import com.android.tools.r8.D8Command
import com.android.tools.r8.OutputMode
import com.raival.fileexplorer.tab.file.d8.DexDiagnosticHandler
import com.raival.fileexplorer.tab.file.misc.BuildUtils
import com.raival.fileexplorer.tab.file.model.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.nio.file.Path

class Jar2DexTask(private val fileToConvert: File) : Task() {
    private var activeDirectory: File? = null
    override val name: String
        get() = "Jar2Dex"
    override val details: String
        get() = fileToConvert.absolutePath
    override val isValid: Boolean
        get() = fileToConvert.exists()

    override fun setActiveDirectory(directory: File) {
        activeDirectory = directory
    }

    override fun start(onUpdate: OnUpdateListener, onFinish: OnFinishListener) {
        CoroutineScope(Dispatchers.IO).launch {
            Handler(Looper.getMainLooper()).post { onUpdate.onUpdate("Converting....") }
            try {
                runD8(fileToConvert, activeDirectory)
                withContext(Dispatchers.Main) { onFinish.onFinish("File has been converted successfully") }
            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) { onFinish.onFinish(e.toString()) }
            }
        }.start()
    }

    private fun runD8(file: File, currentPath: File?) {
        val path: MutableList<Path> = ArrayList()
        path.add(BuildUtils.lambdaStubsJarFile.toPath())
        path.add(BuildUtils.rtJarFile.toPath())
        val command = D8Command.builder(DexDiagnosticHandler())
            .addLibraryFiles(path)
            .addProgramFiles(file.toPath())
            .setMode(CompilationMode.RELEASE)
            .setOutput(currentPath!!.toPath(), OutputMode.DexIndexed)
            .build()
        D8.run(command)
    }
}
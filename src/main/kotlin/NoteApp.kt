import DataBase.MainArchive //import 14;12

var isArchiveMenu: Boolean = true

var commandForMenu: Int = 0
var stopApp = false


fun startMenu() {
    while (true) {
        if (stopApp) {
            println("Приложение завершило работу")
            break
        }
        println("1. Создать элемент")
        if (isArchiveMenu) DataBase.getMenuElement() else MainArchive.get(commandForMenu)?.getMenuElement()
        println("0. Выход")
        menuNavigation()
    }
}

fun menuNavigation() {
    val command = getCommand()
    when (command) {
        1 -> if (isArchiveMenu) DataBase.addElement() else MainArchive.get(commandForMenu)?.addElement()
        0 -> if (isArchiveMenu) stopApp = true else isArchiveMenu = true
        else -> if (isArchiveMenu) {
            commandForMenu = command
            isArchiveMenu = false
        } else {
            MainArchive.get(commandForMenu)?.archiveNotes?.get(command).toString()
        }
    }
}

fun getCommand(): Int {
    while (true) {
        try {
            val command = scanner.nextLine().toInt()
            if (commandFilter(command) or (command == 0) or (command == 1)) {
                return command
            } else {
                errorCommand()
            }
        } catch (e: Exception) {
            errorCommand()
        }
    }
}

fun commandFilter(command: Int): Boolean {
    return if (isArchiveMenu and MainArchive.containsKey(command)) {
        true
    } else if (!isArchiveMenu and (MainArchive.get(commandForMenu)?.archiveNotes?.containsKey(command) == true)) {
        true
    } else {
        false
    }
}


fun errorCommand() {
    println("Некорректный ввод, введите цифру для навигации по меню")
    println("Выберите один из существующих объектов меню")
    startMenu()
}
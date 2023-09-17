data class Archive(val name: String, val archiveNotes: MutableMap<Int, Note>) : MenuFunction { //Интерфейс

    private var numNote: Int = 2

    override fun getMenuElement() {
        if (archiveNotes.isNotEmpty()) {
            archiveNotes.forEach { (i, archive) ->
                println("$i ${archive.name}")
            }
        }
    }

    override fun addElement() {
        while (true) {
            println("Введите название Заметки")
            val name = scanner.nextLine()
            println("Введите текст Заметки")
            val text = scanner.nextLine()
            if (name.isNotEmpty() && text.isNotEmpty()) {
                archiveNotes.put(numNote++, Note(name, text))
                break
            } else {
                println("Название заметки или текст заметки не могут быть пустыми ")
                continue
            }
        }
    }
}
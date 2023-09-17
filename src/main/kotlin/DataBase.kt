object DataBase : MenuFunction{
    val MainArchive: MutableMap<Int, Archive> = mutableMapOf()

    private var numArchive: Int = 2

    override fun addElement() {
        while (true) {
            println("Введите название архива")
            val name = scanner.nextLine()
            if (name.isNotEmpty()) {
                MainArchive.put(numArchive++, Archive(name, mutableMapOf()))
                break
            } else {
                println("Название архива не может быть пустым")
                continue
            }
        }
    }

    override fun getMenuElement() {
        MainArchive.forEach { (i, arcive) ->
            println("$i. ${arcive.name}")
        }
    }
}
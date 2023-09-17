data class Note(val name: String, val text: String) {
    override fun toString(): String {
        println("--------------------------------")
        println("Название заметки: $name")
        println("Текст: $text")
        println("--------------------------------")
        return super.toString()
    }
}

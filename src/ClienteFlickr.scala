import java.util.Properties

object ClienteFlickr extends App {

    /* vamos ler api key a partir de um arquivo
       usando a classe Java Properties.
       import java.util.Properties
    * */
    val props = new Properties()
    props.load(getClass.getClassLoader.getResourceAsStream("config.properties"))

    val apiKey = props.getProperty("flickr.api.key")
    val method = "flickr.photos.search"
    val tags = "scala"

    val url = s"https://api.flickr.com/services/rest/?method=$method&api_key=$apiKey&tags=$tags"

    scala.io.Source.fromURL(url).getLines().foreach(println)
}

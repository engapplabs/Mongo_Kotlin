import com.mongodb.*

/**
 * Created by animal505 on 11/06/17.
 */
fun main(args: Array<String>) {
    val USER: String = "user"
    val PASS: String = "user"
    val URL: String = "mongodb://$USER:$PASS@ds035438.mlab.com:35438/kotlin_mongo"

    var collection: DBCollection? = null
    val db: DB

    val basicDBObject =  BasicDBObject()
    basicDBObject.put("name", "Aurelio")
    basicDBObject.put("age", 19)

    try {
        val mongoDB:MongoClient = MongoClient(MongoClientURI(URL))
        db = mongoDB.getDB("kotlin_mongo")
        collection = db.getCollection("customers_data")

        //INSERT
        //collection.insert(basicDBObject)

        //GET
        val cursor = collection.find()
        while(cursor.hasNext())
            println(cursor.next())
    } catch (e: Exception) {
        println(e.message)
    }
    
}

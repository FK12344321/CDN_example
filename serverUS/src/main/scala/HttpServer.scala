import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.javadsl.marshalling.Marshaller
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import java.io._


object HttpServer extends App {
  implicit val actorSystem = ActorSystem(Behaviors.empty, "akka-http")
  implicit val stringMarshaller = Marshaller

  val route = get {
    path(Segment) {
      fileName => complete(HttpEntity.fromFile(MediaTypes.`image/svg+xml`, new File(fileName)))
    }
  }

  val bindFuture = Http().newServerAt("0.0.0.0", 8081).bind(route)

  while(true) {}
}

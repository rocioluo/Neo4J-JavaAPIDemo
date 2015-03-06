package com.tp.neo4j.java.examples;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
public class Neo4JJavaAPIDBOperation {
	public enum ArtMovement implements Label {
		ARTWORK,ARTIST,EXHIBITION,DOCUMENT,
	}
	public enum ArtMovementRelationships implements RelationshipType{
		JVM_LANGIAGES,NON_JVM_LANGIAGES;
	}
	public static void main(String[] args) {
		GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
		GraphDatabaseService db= dbFactory.newEmbeddedDatabase("D:/pitt/advaced database/default.graphdb");
		try (Transaction tx = db.beginTx()) {
			// Perform DB operations	
			Node javaNode = db.createNode(ArtMovement.ARTWORK);
			javaNode.setProperty("TutorialID", "JAVA001");
			javaNode.setProperty("Title", "Learn Java");
			javaNode.setProperty("NoOfChapters", "25");
			javaNode.setProperty("Status", "Completed");				
			
			Node scalaNode = db.createNode(ArtMovement.ARTIST);
			scalaNode.setProperty("TutorialID", "SCALA001");
			scalaNode.setProperty("Title", "Learn Scala");
			scalaNode.setProperty("NoOfChapters", "20");
			scalaNode.setProperty("Status", "Completed");
			
			Relationship relationship = javaNode.createRelationshipTo
			(scalaNode,ArtMovementRelationships.JVM_LANGIAGES);
			relationship.setProperty("Id","1234");
			relationship.setProperty("OOPS","YES");
			relationship.setProperty("FP","YES");
			tx.success();
		}
		System.out.println("Done successfully");
	}

}

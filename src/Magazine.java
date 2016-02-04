/**
 * Created by Oscar Duarte on 2/1/16.
 * CE 3345
 */
public class Magazine {

    /**
     * standard variables that hold all the information
     * the node would hold
     */

    int magazineID;
    String magazineName;
    String publisherName;
    Magazine next;

    /**
     * default constructor, unused but is what is created
     * if no parameters given
     */

    public Magazine(){
        magazineID = -1;
        magazineName = null;
        publisherName = null;
        next = null;
    }

    /**
     * overloaded constructor with data that is given
     * @param magID the Magazine ID
     * @param magNm the Magazine Name
     * @param pubNm the Publisher Name
     */

    public Magazine(int magID, String magNm, String pubNm){
        magazineID = magID;
        magazineName = magNm;
        publisherName = pubNm;
        next = null;
    }

    /**
     * setNext sets the next node in the chain to given node
     * @param m the new node
     */
    public void setNext(Magazine m){
        next = m;
    }

    /**
     * getMagazineName returns the magazine name data
     * of the node
     * @return the magazine name of node
     */

    public String getMagazineName(){
        return magazineName;
    }

    /**
     * getMagazineID returns the magazine id of the node
     * @return the magazine ID of the node
     */

    public int getMagazineID(){
        return magazineID;
    }

    /**
     * getPublisherName returns the publisher name of the node
     * @return the publisher name of the node
     */

    public String getPublisherName(){
        return publisherName;
    }

    /**
     * getNext returns the node this node is pointing to
     * @return the next node
     */

    public Magazine getNext(){
        return next;
    }

    /**
     * print is a toString method that returns all the data of the list
     * organized
     * @return a string containing the magID, mag name, and pub name
     */

    public String print(){
        return "Magazine ID: " + getMagazineID() + "\nMagazine Name: " + getMagazineName() + "\nPublisher Name: " + getPublisherName() + "\n";
    }

    /**
     * compareID compares the id of a node to a given id
     * @param id the id the node's id is compared to
     * @return returns whether a node matches or does not match the id
     */

    public boolean compareID(int id){
        return id == magazineID;
    }
}

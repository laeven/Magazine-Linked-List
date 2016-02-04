/**
 * Created by Oscar Duarte on 2/1/16.
 * CE 3345
 */
public class MagazineList {

    /**
     * Magazine head is the first element of the list
     */
    Magazine head;

    /**
     * MagazineList is the default constructor, instantiates the head as null
     * as there is not pre-made list
     */

    public MagazineList(){
        head = null;
    }

    /**
     * makeEmpty empties the list by making the head null
     * so it's pointing to nothing.
     */

    public void makeEmpty(){
        head = null;
    }

    /**
     * findID searches through the list looking for a magazine
     * that matches the given id
     * @param id the given id being searched for
     * @return returns the magazine if found, null if not found
     */

    public Magazine findID(int id){
        Magazine cur = head;
        if(cur == null){
            return null;
        }
        while(cur != null){
            if(cur.compareID(id))
                return cur;
            cur = cur.getNext();
        }
        return null;
    }

    /**
     * insertAtFront takes a given Magazine and inputs it at the front of the list.
     * It first checks if any magazine has the same id, if there is one
     * placing it in list fails
     * @param mag the given magazine to be placed
     * @return returns true or false depending on whether magazine is placed.
     */

    public boolean insertAtFront(Magazine mag){
        Magazine cur = head;
        while(cur != null){
            if(cur.compareID(mag.getMagazineID()))
                return false;
            cur = cur.getNext();
        }
        mag.setNext(head);
        head = mag;
        return true;
    }

    /**
     * deleteFromFront deletes the first magazine and then
     * returns the same Magazine
     * @return the magazine that was deleted
     */

    public Magazine deleteFromFront(){
        Magazine temp = head;
        if(head != null)
            head = head.getNext();
        return temp;
    }

    /**
     * delete deletes the magazine that matches the id given
     * if that magazine exists, if it does, it returns true
     * if not it returns false.
     * @param id the id given to find
     * @return true if id found and deleted, false if not found
     */

    public boolean delete(int id){
        Magazine cur = head;
        if(cur == null)
            return false;
        if(cur.getNext() == null) {
            if (head.compareID(id)){
                head = null;
                return true;
            }
        }
        while(cur.getNext() != null){
            if(cur.getNext().compareID(id)){
                cur.setNext(cur.getNext().getNext());
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }

    /**
     * printAllRecords is essentially a toString of the list, marking
     * them numerically in the list as well as listing all the information
     */

    public void printAllRecords(){
        Magazine cur = head;

        if(head == null){
            System.out.println("\nThe list is empty\n");
        }
        else {
            int counter = 1;
            while (cur != null) {
                System.out.println("Magazine #" + counter++);
                System.out.println(cur.print());
                cur = cur.getNext();
            }
        }
    }
}

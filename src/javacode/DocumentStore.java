package javacode;

import java.util.*;

public class DocumentStore {
    private Collection<String> documents = new ArrayList<String>();
    private int capacity;

    public DocumentStore(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() { 
      return this.capacity;
    }

    public Collection<String> getDocuments() {
    	return Collections.unmodifiableCollection(this.documents);
    }

    public void addDocument(String document) {
        if (this.documents.size() >= capacity)
            throw new IllegalStateException();

        documents.add(document);
    }
    
    @Override 
    public String toString() {
        return String.format("Document store: %d/%d", documents.size(), this.capacity);
    }
    
    public static void main(String[] args) {
        DocumentStore documentStore = new DocumentStore(2);
        documentStore.addDocument("item1");
        documentStore.addDocument("item2");
        System.out.println(documentStore);
    }
}

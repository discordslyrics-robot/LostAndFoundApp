package com.example.lostfoundmypart.activities;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

public class FirebaseHelper {

    private static final FirebaseFirestore db = FirebaseFirestore.getInstance();

    public static void getItems(String collectionName, OnCompleteListener<QuerySnapshot> listener) {
        CollectionReference ref = db.collection(collectionName);
        ref.get().addOnCompleteListener(listener);
    }
    
    public static void getItemsSortedByDate(String collectionName, Query.Direction direction, OnCompleteListener<QuerySnapshot> listener) {
        CollectionReference ref = db.collection(collectionName);
        ref.orderBy("date", direction).get().addOnCompleteListener(listener);
    }

    public static void searchItems(String collectionName, String field, String queryText, OnCompleteListener<QuerySnapshot> listener) {
        CollectionReference ref = db.collection(collectionName);
        ref.orderBy(field)
           .startAt(queryText)
           .endAt(queryText + "\uf8ff")
           .get().addOnCompleteListener(listener);
    }
    
    public static void filterItems(String collectionName, String field, String value, OnCompleteListener<QuerySnapshot> listener) {
        CollectionReference ref = db.collection(collectionName);
        ref.whereEqualTo(field, value).get().addOnCompleteListener(listener);
    }
}

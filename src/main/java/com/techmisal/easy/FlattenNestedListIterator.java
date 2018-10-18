package com.techmisal.easy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FlattenNestedListIterator {

    public static List<Object> FlattenList(List<?> nestedList) {
        // Method takes a nested list as argument and returns a deep copy of the same list,
        // but flattened. This will be done by calling FlattenList recursively whenever we
        // find a nested list
        List<Object> flattenedList = new ArrayList<>();
        
        FlattenList(flattenedList, nestedList);

        return flattenedList;
    }

    private static void FlattenList(List flatList, List nestedList) {
        // Iterate over items in nested list
        for(Object item : nestedList) {
            // If item is of a Collection, e.g. a List, call this function recursively
            if(item instanceof Collection<?>) {
                FlattenList(flatList, (List) item);
            } else {
                // Item was not of a Collection, push it to flatList (flattenedList)
                flatList.add(item);
            }
        }
    }

}
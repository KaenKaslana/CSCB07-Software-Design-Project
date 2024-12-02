package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> originalCategoryList; // Original category list
    private List<String> filteredCategoryList; // Filtered category list
    private HashMap<String, List<String>> originalHabitMap; // Original habits
    private HashMap<String, List<String>> filteredHabitMap; // Filtered habits

    public ExpandableListAdapter(Context context, List<String> categoryList, HashMap<String, List<String>> habitMap) {
        this.context = context;
        this.originalCategoryList = new ArrayList<>(categoryList);
        this.filteredCategoryList = new ArrayList<>(categoryList);
        this.originalHabitMap = new HashMap<>(habitMap);
        this.filteredHabitMap = new HashMap<>(habitMap);
    }

    @Override
    public int getGroupCount() {
        return filteredCategoryList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        String category = filteredCategoryList.get(groupPosition);
        return filteredHabitMap.get(category).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return filteredCategoryList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        String category = filteredCategoryList.get(groupPosition);
        return filteredHabitMap.get(category).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String categoryTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_expandable_list_item_1, parent, false);
        }
        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(categoryTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String habitTitle = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(habitTitle);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void filter(String query) {
        query = query.toLowerCase();
        filteredCategoryList.clear();
        filteredHabitMap.clear();

        if (query.isEmpty()) {
            // Restore original data
            filteredCategoryList.addAll(originalCategoryList);
            filteredHabitMap.putAll(originalHabitMap);
        } else {
            // Filter categories and habits
            for (String category : originalCategoryList) {
                List<String> filteredHabits = new ArrayList<>();
                for (String habit : originalHabitMap.get(category)) {
                    if (habit.toLowerCase().contains(query)) {
                        filteredHabits.add(habit);
                    }
                }
                if (!filteredHabits.isEmpty()) {
                    filteredCategoryList.add(category);
                    filteredHabitMap.put(category, filteredHabits);
                }
            }
        }


        notifyDataSetChanged();
    }
}

package com.example.courses;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView branchesListView;
    private List<EngineeringBranch> branches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        branchesListView = findViewById(R.id.branchesListView);
        initializeBranches();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                getBranchNames()
        );
        branchesListView.setAdapter(adapter);

        branchesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showBranchDetails(position);
            }
        });



    }

    private void initializeBranches() {
        branches = new ArrayList<>();
        branches.add(new EngineeringBranch("Computer Science", 8, Arrays.asList("Programming", "Data Structures", "Algorithms", "Database Systems")));
        branches.add(new EngineeringBranch("Mechanical", 8, Arrays.asList("Thermodynamics", "Fluid Mechanics", "Machine Design", "Dynamics")));
        branches.add(new EngineeringBranch("Civil", 8, Arrays.asList("Structural Analysis", "Geotechnical Engineering", "Hydraulics", "Surveying")));
        branches.add(new EngineeringBranch("Electrical", 8, Arrays.asList("Circuit Theory", "Electromagnetics", "Control Systems", "Power Systems")));
    }

    private List<String> getBranchNames() {
        List<String> branchNames = new ArrayList<>();
        for (EngineeringBranch branch : branches) {
            branchNames.add(branch.getName());
        }
        return branchNames;
    }

    private void showBranchDetails(int position) {
        EngineeringBranch selectedBranch = branches.get(position);
        StringBuilder details = new StringBuilder("Semesters: " + selectedBranch.getSemesters() + "\nSubjects:\n");
        for (String subject : selectedBranch.getSubjects()) {
            details.append("- ").append(subject).append("\n");
        }

        new AlertDialog.Builder(this)
                .setTitle(selectedBranch.getName())
                .setMessage(details.toString())
                .setPositiveButton("OK", null)
                .show();
    }
}
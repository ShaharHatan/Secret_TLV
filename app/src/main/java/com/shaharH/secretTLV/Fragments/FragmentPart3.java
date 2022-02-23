package com.shaharH.secretTLV.Fragments;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.shaharH.secretTLV.Callback.FilledInFragment;
import com.shaharH.secretTLV.R;

import java.util.ArrayList;
import java.util.UUID;

public class FragmentPart3 extends Fragment implements FilledInFragment {
    private AppCompatImageButton upload_IBN;

    private ArrayList<Uri> myUriList;
    private ArrayList<String> urlList;

    private Activity activity;


    private ActivityResultLauncher<Intent> myActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        Intent data = result.getData();
                        myUriList.add(data.getData());
                    }
                }
            });


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_part3, container, false);

        findViews(view);
        initViews();

        return view;
    }

    public ArrayList<String> getUrlList() {
        return urlList;
    }

    private void initViews() {
        myUriList = new ArrayList<>();
        urlList = new ArrayList<>();

        upload_IBN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });
    }


    private void findViews(View view) {
        upload_IBN = view.findViewById(R.id.upload_IBN);
    }

    @Override
    public Boolean checkFillInFields() {
        setUrlList();
        return true;
    }

    private void setUrlList() {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();

        myUriList.forEach((imageUri) -> {
        StorageReference tempRef = storageRef
                .child("image_list/" + UUID.randomUUID().toString());
            tempRef.putFile(imageUri).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    //Handle unsuccessful upload
                    Toast.makeText(getContext(), "unable to upload image", Toast.LENGTH_SHORT).show();
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    //Handle successful upload
                    Toast.makeText(getContext(), "Uploaded image", Toast.LENGTH_SHORT).show();
                    tempRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            urlList.add(uri.toString());
                            Log.i("info", uri.toString());
                        }
                    });
                }
            });
        });
    }

    private void chooseImage() {
        Log.i("info", "Creating Intent for choosing a image");
        Intent intent = new Intent();
        //setType - The MIME type of the data being handled by this intent
        intent.setType("image/*");
        //ACTION_GET_CONTENT - Allow the user to select a particular kind of data and return it
        intent.setAction(Intent.ACTION_GET_CONTENT);
        myActivityResultLauncher.launch(intent);
    }

}

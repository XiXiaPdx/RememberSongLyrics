package com.xixia.remembersonglyrics.UI;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xixia.remembersonglyrics.Constants;
import com.xixia.remembersonglyrics.R;
import com.xixia.remembersonglyrics.Services.FirebaseService;
import com.xixia.remembersonglyrics.Services.FragmentService;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EmailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EmailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmailFragment extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;
    @BindView(R.id.acceptEmailAddress) Button acceptEmailButton;
    @BindView(R.id.emailAddress) EditText userEditText;

    public EmailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment EmailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EmailFragment newInstance() {
        EmailFragment fragment = new EmailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_email, container, false);
        ButterKnife.bind(this, view);
        acceptEmailButton.setOnClickListener(this);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        FirebaseService.getDatabase().getReference().child("servicePushTestNode").push().setValue("test");

        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override

    public void onClick(View view) {
        if (view == acceptEmailButton){
            String emailAddress = userEditText.getText().toString().trim();
           if(validate(emailAddress)){
               //store and pass into next fragment
               FragmentService fragmentService = new FragmentService(getActivity());
               fragmentService.loadFragment(EmailFragment.newInstance(), Constants.LOGIN_CONTAINER);
           }
        }
    }

    public Boolean validate (String emailAddress){
        if (emailAddress.length() > 0 && emailAddress.contains("@")){
            return true;
        } else {
            Toast.makeText(getActivity(), getResources().getString(R.string.invalid_email), Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

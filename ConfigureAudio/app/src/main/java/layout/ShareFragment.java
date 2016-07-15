package layout;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.audio.kramer.configureaudio.MainActivity;
import com.audio.kramer.configureaudio.R;

import entity.AudioCursorAdapter;
import entity.entries.DatabaseContract;
import entity.entries.SpeakerEntry;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShareFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShareFragment//#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShareFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_PARAM1 = "nameSpeaker";
    public static final String ARG_PARAM2 = "nameAmplifire";

    // TODO: Rename and change types of parameters
    private String nameSpeaker;
    private String nameAmplifire;

    private OnFragmentInteractionListener mListener;

    public ShareFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     //* @param param1 Parameter 1.
     //* @param param2 Parameter 2.
     * @return A new instance of fragment ShareFragment.
     */
    // TODO: Rename and change types and number of parameters
//    public static ShareFragment newInstance(String nameSpeaker, String nameAmplifire) {
//        ShareFragment fragment = new ShareFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, nameSpeaker);
//        args.putString(ARG_PARAM2, nameAmplifire);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            nameSpeaker = getArguments().getString(ARG_PARAM1);
//            nameAmplifire = getArguments().getString(ARG_PARAM2);
//        }
    }

    protected View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //nameSpeaker  = ((MainActivity)getActivity()).nameSpeaker;
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_share, container, false);
        this.mView = view;
//        getData();
        return mView;//inflater.inflate(R.layout.fragment_speaker, container, false);
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        customAdapter = new CustomCursorAdapter(MyActivity.this, databaseHelper.getAllData());
//        listView.setAdapter(customAdapter);
//
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_share, container, false);
//    }

    private void getData() {
        Cursor cursor;
        try {
            String[] projection =  {SpeakerEntry.ID, SpeakerEntry.PORT_NUMBER, SpeakerEntry.NAME, SpeakerEntry.DESCRIPTION}; //"aaa description", "123 port_number"};
            String selection = SpeakerEntry.NAME + " = ? ";
            String[] strArgs = {nameSpeaker};
            Uri uri = DatabaseContract.BASE_CONTENT_URI.buildUpon().appendPath(DatabaseContract.PATH_SPEAKER_FILTER).build();
            cursor = getActivity().getContentResolver().query(SpeakerEntry.CONTENT_URI, projection, selection, strArgs, null);
            AudioCursorAdapter customAdapter = new AudioCursorAdapter(getActivity(), cursor);
            ListView listView = (ListView) mView.findViewById(R.id.list_data);
            listView.setAdapter(customAdapter);
            //cursor.close();
        }
        catch (Exception e) {
            e.getStackTrace();
            Log.e("Message err", e.getMessage());
        }
//        finally{
//            if(cursor != null && !cursor.isClosed()){
//                cursor.close();
//            }
//        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

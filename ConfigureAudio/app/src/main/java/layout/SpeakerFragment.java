package layout;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.audio.kramer.configureaudio.R;

import entity.ParamsData;
import entity.entries.DatabaseContract;
import entity.entries.SpeakerEntry;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SpeakerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SpeakerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpeakerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public static ParamsData paramsData;

    private OnFragmentInteractionListener mListener;

    public SpeakerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
          * @return A new instance of fragment SpeakerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SpeakerFragment newInstance(ParamsData paramsDataArg) {

        SpeakerFragment fragment = new SpeakerFragment();
        paramsData = paramsDataArg;

//        Bundle args = new Bundle();
//        args.putAll(ARG_PARAM1, paramsData);
//        args.putString(ARG_PARAM2, param2);
        //fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSpeakers();

//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    protected View mView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_speaker, container, false);
        this.mView = view;
        getSpeakers();
        return mView;//inflater.inflate(R.layout.fragment_speaker, container, false);
    }

    private void getSpeakers() {
        //no update
        paramsData.Installation(SpeakerEntry.INSTALLATION_CEILING_TILE);
        paramsData.High(8);

        String strFilterInches = "";
        if (paramsData.Installation() == SpeakerEntry.INSTALLATION_CEILING || paramsData.Installation() == SpeakerEntry.INSTALLATION_CEILING_TILE) {
            if (paramsData.High() <= 3)
                strFilterInches = "4";
            else if (paramsData.High() > 3 && paramsData.High() <= 5)
                strFilterInches = "6.5";
            else if (paramsData.High() > 5)// && paramsData.High() <= 8)
                strFilterInches = "8";
        }
        else {
            if (paramsData.Width() <= 3)
                strFilterInches = "4";
            else if (paramsData.Width() > 3 && paramsData.Width() <= 5)
                strFilterInches = "5.25";
            else if (paramsData.Width() > 5)
                strFilterInches = "6.5";
        }

        String[] strArgs = {paramsData.Installation(), strFilterInches};
        Uri uri = DatabaseContract.BASE_CONTENT_URI.buildUpon().appendPath(DatabaseContract.PATH_SPEAKER_FILTER).build();
        Cursor cursor = getActivity().getContentResolver().query(uri , null, null, strArgs, SpeakerEntry.QUALITY); ////SPEAKERS_CONTENT_URI

        int flag = 0;
        if (cursor.moveToFirst()) {
            while(!cursor.isAfterLast() && flag < 2) { // If you use c.moveToNext() here, you will bypass the first row, which is WRONG
                flag ++;
                String strDescription = cursor.getString(cursor.getColumnIndexOrThrow(SpeakerEntry.INCHES)) + "-Inch, " + cursor.getString(cursor.getColumnIndexOrThrow(SpeakerEntry.INSTALLATION)) + " Speakers";
                if (flag == 1) {
                    TextView txt1 = (TextView) mView.findViewById(R.id.spk_txt1);
                    txt1.setText(cursor.getString(cursor.getColumnIndexOrThrow(SpeakerEntry.NAME)));
                    TextView txt11 = (TextView) mView.findViewById(R.id.spk_txt11);
                    txt11.setText(strDescription);
                    Button btn1 = (Button) mView.findViewById(R.id.spk_1);
                    btn1.setText("Comercial");
                    switch (paramsData.Installation())
                    {
                        case SpeakerEntry.INSTALLATION_CEILING_TILE:
                            btn1.setBackground(getResources().getDrawable(R.drawable.ceiling_tile_hp));
                            btn1.setText("High Performance");
                            break;
                        case SpeakerEntry.INSTALLATION_CEILING:
                            btn1.setBackground(getResources().getDrawable(R.drawable.ceiling_com));
                            break;
                        case SpeakerEntry.INSTALLATION_ON_WALL:
                            btn1.setBackground(getResources().getDrawable(R.drawable.on_wall_com));
                            break;
                        case SpeakerEntry.INSTALLATION_IN_WALL:
                            btn1.setBackground(getResources().getDrawable(R.drawable.in_wall_com));
                            break;
                        default:
                            break;
                    }
                }
                else if (flag == 2) {
                    TextView txt1 = (TextView) mView.findViewById(R.id.spk_txt2);
                    txt1.setText(cursor.getString(cursor.getColumnIndexOrThrow(SpeakerEntry.NAME)));
                    TextView txt11 = (TextView) mView.findViewById(R.id.spk_txt22);
                    txt11.setText(strDescription);
                    Button btn2 = (Button) mView.findViewById(R.id.spk_2);
                    btn2.setText("High Performance");
                    switch (paramsData.Installation())
                    {
//                        case SpeakerEntry.INSTALLATION_CEILING_TILE:
//                            btn2.setBackground(getResources().getDrawable(R.drawable.ceiling_tile_hp));
//                            break;
                        case SpeakerEntry.INSTALLATION_CEILING:
                            btn2.setBackground(getResources().getDrawable(R.drawable.ceiling_hp));
                            break;
                        case SpeakerEntry.INSTALLATION_ON_WALL:
                            btn2.setBackground(getResources().getDrawable(R.drawable.on_wall_hp));
                            break;
                        case SpeakerEntry.INSTALLATION_IN_WALL:
                            btn2.setBackground(getResources().getDrawable(R.drawable.in_wall_hp));
                            break;
                        default:
                            break;
                    }

                }
                cursor.moveToNext();
            }
        }

        if (flag < 2){ //paramsData.Installation() == SpeakerEntry.INSTALLATION_CEILING_TILE) {
            Button btn2 = (Button) mView.findViewById(R.id.spk_2);
            btn2.setVisibility(View.GONE);
            TextView txt2 = (TextView) mView.findViewById(R.id.spk_txt2);
            txt2.setVisibility(View.GONE);
            TextView txt22 = (TextView) mView.findViewById(R.id.spk_txt22);
            txt22.setVisibility(View.GONE);
            //Toast.makeText(getActivity(),"Text!",Toast.LENGTH_SHORT).show();
        }

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

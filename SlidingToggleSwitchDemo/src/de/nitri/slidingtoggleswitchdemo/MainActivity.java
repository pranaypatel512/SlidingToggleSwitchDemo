package de.nitri.slidingtoggleswitchdemo;

import de.nitri.slidingtoggleswitch.OnToggleListener;
import de.nitri.slidingtoggleswitch.SlidingToggleSwitchView;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends FragmentActivity implements OnToggleListener {

	private TextView tvSelected;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}

	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			((MainActivity) getActivity()).tvSelected = (TextView) rootView
					.findViewById(R.id.textView1);
			((MainActivity) getActivity()).tvSelected
					.setText(getString(R.string.left_button_text));
			return rootView;
		}
	}

	@Override
	public void onToggle(int result) {

		if (result == SlidingToggleSwitchView.LEFT_SELECTED)
			tvSelected.setText(getString(R.string.left_button_text));
		else
			tvSelected.setText(getString(R.string.right_button_text));

	}
}

package club.sgen.bettingpop;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import club.sgen.network.R;

public class PopupbettingstartActivity extends Activity implements
		OnClickListener {
	private ImageView ok;
	private ImageView cancel;
	private ImageView close;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.popup_bettingstart_start);

		ok = (ImageView) findViewById(R.id.popup_bettingstart_start_ok);
		cancel = (ImageView) findViewById(R.id.popup_bettingstart_start_cancel);
		close = (ImageView) findViewById(R.id.popup_bettingstart_start_close);
		ok.setOnClickListener(this);
		cancel.setOnClickListener(this);
		close.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		if (arg0 == ok)
			setResult(Activity.RESULT_OK);
		else if (arg0 == cancel)
			setResult(Activity.RESULT_CANCELED);
		finish();
	}
}

package training.android.trainingunitconverter;

import java.util.ArrayList;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.Smoke;
import android.widget.EditText;
import android.widget.Spinner;

import com.jayway.android.robotium.solo.Solo;


public class UnitConverterTest extends ActivityInstrumentationTestCase2<UnitConverter>{

	private Solo solo;

	public UnitConverterTest() {
		super("training.android.trainingunitconverter", UnitConverter.class);

	}

	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
	}


	@Smoke
	public void testUnitDropDown() throws Exception {
		
		solo.assertCurrentActivity("Expected UnitConverter activity", "UnitConverter"); 
		ArrayList<Spinner> ArrayofSpiners = solo.getCurrentSpinners();
		//solo.pressSpinnerItem(0,1);
		Spinner unit = (Spinner)solo.getView(R.id.SpinnerUnit);
		solo.pressSpinnerItem(0, 1);
		/*if (!solo.waitForText("Weight")) {
			fail("result != 'Weight'");
		}*/

		solo.sleep(2000);
		EditText value = (EditText)solo.getView(R.id.EditTextValue);
		solo.enterText(value, "1");
		solo.pressSpinnerItem(1,0);
		solo.sleep(1000);
		solo.pressSpinnerItem(2,1);
		solo.sleep(1000);
		solo.clickOnButton(0);
		assertTrue(solo.searchText("1000.0"));
	}

	@Override
	public void tearDown() throws Exception {
		//Robotium will finish all the activities that have been opened
		solo.finishOpenedActivities();
	}
}
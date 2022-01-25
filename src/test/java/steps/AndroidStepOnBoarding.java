package steps;

import io.cucumber.java.en.And;
import pages.AndroidPagePool;

public class AndroidStepOnBoarding {
    @And("User explored on boarding page")
    public void userExploredOnBoardingPage() {
        int numOfOnBoarding = 3;
        for (int i = 0; i < numOfOnBoarding; i++) {
            AndroidPagePool.androidPageOnBoarding.singleTap(AndroidPagePool.androidPageOnBoarding.buttonNext);
        }
        AndroidPagePool.androidPageOnBoarding.singleTap(AndroidPagePool.androidPageOnBoarding.buttonLetsGo);
    }
}

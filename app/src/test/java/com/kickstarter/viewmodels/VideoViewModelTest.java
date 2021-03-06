package com.kickstarter.viewmodels;

import android.content.Intent;

import com.kickstarter.KSRobolectricTestCase;
import com.kickstarter.factories.ProjectFactory;
import com.kickstarter.models.Project;
import com.kickstarter.ui.IntentKey;

import org.junit.Test;

import rx.observers.TestSubscriber;

public class VideoViewModelTest extends KSRobolectricTestCase {

  @Test
  public void testVideoViewModel_EmitsVideoUrl() {
    final VideoViewModel.ViewModel vm = new VideoViewModel.ViewModel(environment());
    final Project project = ProjectFactory.project();

    final TestSubscriber<String> preparePlayerWithUrl = new TestSubscriber<>();
    vm.outputs.preparePlayerWithUrl().subscribe(preparePlayerWithUrl);

    // Configure the view model with a project intent.
    vm.intent(new Intent().putExtra(IntentKey.PROJECT, project));

    preparePlayerWithUrl.assertValues(project.video().high());
  }
}

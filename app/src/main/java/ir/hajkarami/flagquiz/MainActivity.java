package ir.hajkarami.flagquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Set;


public class MainActivity extends AppCompatActivity {

    public static final String CHOICES = "pref_numberOfChoices";
    public static final String REGIONS = "pref_regionsToInclude";
    OnSharedPreferenceChangeListener preferenceChangeListener;

    private boolean preferencesChanged = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        preferenceChangeListener = (sharedPreferences, key)
                -> {
        };

        PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(preferenceChangeListener);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferenceManager.getDefaultSharedPreferences(this)
                .unregisterOnSharedPreferenceChangeListener(preferenceChangeListener);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (preferencesChanged) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            QuizFragment quizFragment = (QuizFragment) fragmentManager.findFragmentById(R.id.fragmentContainerView);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Intent preferenceIntent = new Intent(this, SettingsActivity.class);
            startActivity(preferenceIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private OnSharedPreferenceChangeListener preferencesChangeListener =
            new OnSharedPreferenceChangeListener() {
                @Override
                public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, @Nullable String key) {
                    preferencesChanged = true;
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    QuizFragment quizFragment = (QuizFragment) fragmentManager.findFragmentById(R.id.fragmentContainerView);
                    if (key.equals(CHOICES)) {
                        quizFragment.updateGuessRows(sharedPreferences);
                        quizFragment.resetQuiz();
                    } else if (key.equals(REGIONS)) {
                        Set<String> region =
                                sharedPreferences.getStringSet(REGIONS, null);
                        if (region != null && region.size() > 0) {
                            quizFragment.updateRegions(sharedPreferences);
                            quizFragment.resetQuiz();
                        } else {
                            SharedPreferences.Editor editor =
                                    sharedPreferences.edit();
                            editor.putStringSet(REGIONS, region);
                            editor.apply();
                            Toast.makeText(MainActivity.this,
                                    R.string.restarting_quiz,
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            };
}
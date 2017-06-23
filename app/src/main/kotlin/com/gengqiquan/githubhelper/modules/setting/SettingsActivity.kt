package com.gengqiquan.githubhelper.modules.setting


import android.preference.PreferenceActivity
import com.alibaba.android.arouter.facade.annotation.Route

/**
 * A [PreferenceActivity] that presents a set of application settings. On
 * handset devices, settings are presented as a single list. On tablets,
 * settings are split by category, with category headers shown to the left of
 * the list of settings.
 *
 *
 * See [
   * Android Design: Settings](http://developer.android.com/design/patterns/settings.html) for design guidelines and the [Settings
   * API Guide](http://developer.android.com/guide/topics/ui/settings.html) for more information on developing a Settings UI.
 */
@Route(path = "/tab/Settings")
class SettingsActivity : AppCompatPreferenceActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setupActionBar()
    }

    /**
     * Set up the [android.app.ActionBar], if the API is available.
     */
    private fun setupActionBar() {
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    /**
     * {@inheritDoc}
     */
    override fun onIsMultiPane(): Boolean {
        return com.gengqiquan.githubhelper.modules.setting.SettingsActivity.Companion.isXLargeTablet(this)
    }

    /**
     * {@inheritDoc}
     */
    @android.annotation.TargetApi(android.os.Build.VERSION_CODES.HONEYCOMB)
    override fun onBuildHeaders(target: List<android.preference.PreferenceActivity.Header>) {
        loadHeadersFromResource(com.gengqiquan.githubhelper.R.xml.pref_headers, target)
    }

    /**
     * This method stops fragment injection in malicious applications.
     * Make sure to deny any unknown fragments here.
     */
    override fun isValidFragment(fragmentName: String): Boolean {
        return android.preference.PreferenceFragment::class.java.name == fragmentName
                || com.gengqiquan.githubhelper.modules.setting.SettingsActivity.GeneralPreferenceFragment::class.java.name == fragmentName
                || com.gengqiquan.githubhelper.modules.setting.SettingsActivity.DataSyncPreferenceFragment::class.java.name == fragmentName
                || com.gengqiquan.githubhelper.modules.setting.SettingsActivity.NotificationPreferenceFragment::class.java.name == fragmentName
    }

    /**
     * This fragment shows general preferences only. It is used when the
     * activity is showing a two-pane settings UI.
     */
    @android.annotation.TargetApi(android.os.Build.VERSION_CODES.HONEYCOMB)
    class GeneralPreferenceFragment : android.preference.PreferenceFragment() {
        override fun onCreate(savedInstanceState: android.os.Bundle?) {
            super.onCreate(savedInstanceState)
            addPreferencesFromResource(com.gengqiquan.githubhelper.R.xml.pref_general)
            setHasOptionsMenu(true)

            // Bind the summaries of EditText/List/Dialog/Ringtone preferences
            // to their values. When their values change, their summaries are
            // updated to reflect the new value, per the Android Design
            // guidelines.
            com.gengqiquan.githubhelper.modules.setting.SettingsActivity.Companion.bindPreferenceSummaryToValue(findPreference("example_text"))
            com.gengqiquan.githubhelper.modules.setting.SettingsActivity.Companion.bindPreferenceSummaryToValue(findPreference("example_list"))
        }

        override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
            val id = item.itemId
            if (id == android.R.id.home) {
                startActivity(android.content.Intent(activity, SettingsActivity::class.java))
                return true
            }
            return super.onOptionsItemSelected(item)
        }
    }

    /**
     * This fragment shows notification preferences only. It is used when the
     * activity is showing a two-pane settings UI.
     */
    @android.annotation.TargetApi(android.os.Build.VERSION_CODES.HONEYCOMB)
    class NotificationPreferenceFragment : android.preference.PreferenceFragment() {
        override fun onCreate(savedInstanceState: android.os.Bundle?) {
            super.onCreate(savedInstanceState)
            addPreferencesFromResource(com.gengqiquan.githubhelper.R.xml.pref_notification)
            setHasOptionsMenu(true)

            // Bind the summaries of EditText/List/Dialog/Ringtone preferences
            // to their values. When their values change, their summaries are
            // updated to reflect the new value, per the Android Design
            // guidelines.
            com.gengqiquan.githubhelper.modules.setting.SettingsActivity.Companion.bindPreferenceSummaryToValue(findPreference("notifications_new_message_ringtone"))
        }

        override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
            val id = item.itemId
            if (id == android.R.id.home) {
                startActivity(android.content.Intent(activity, SettingsActivity::class.java))
                return true
            }
            return super.onOptionsItemSelected(item)
        }
    }

    /**
     * This fragment shows data and sync preferences only. It is used when the
     * activity is showing a two-pane settings UI.
     */
    @android.annotation.TargetApi(android.os.Build.VERSION_CODES.HONEYCOMB)
    class DataSyncPreferenceFragment : android.preference.PreferenceFragment() {
        override fun onCreate(savedInstanceState: android.os.Bundle?) {
            super.onCreate(savedInstanceState)
            addPreferencesFromResource(com.gengqiquan.githubhelper.R.xml.pref_data_sync)
            setHasOptionsMenu(true)

            // Bind the summaries of EditText/List/Dialog/Ringtone preferences
            // to their values. When their values change, their summaries are
            // updated to reflect the new value, per the Android Design
            // guidelines.
            com.gengqiquan.githubhelper.modules.setting.SettingsActivity.Companion.bindPreferenceSummaryToValue(findPreference("sync_frequency"))
        }

        override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
            val id = item.itemId
            if (id == android.R.id.home) {
                startActivity(android.content.Intent(activity, SettingsActivity::class.java))
                return true
            }
            return super.onOptionsItemSelected(item)
        }
    }

    companion object {
        /**
         * A preference value change listener that updates the preference's summary
         * to reflect its new value.
         */
        private val sBindPreferenceSummaryToValueListener = android.preference.Preference.OnPreferenceChangeListener { preference, value ->
            val stringValue = value.toString()

            if (preference is android.preference.ListPreference) {
                // For list preferences, look up the correct display value in
                // the preference's 'entries' list.
                val listPreference = preference
                val index = listPreference.findIndexOfValue(stringValue)

                // Set the summary to reflect the new value.
                preference.setSummary(
                        if (index >= 0)
                            listPreference.entries[index]
                        else
                            null)

            } else if (preference is android.preference.RingtonePreference) {
                // For ringtone preferences, look up the correct display value
                // using RingtoneManager.
                if (android.text.TextUtils.isEmpty(stringValue)) {
                    // Empty values correspond to 'silent' (no ringtone).
                    preference.setSummary(com.gengqiquan.githubhelper.R.string.pref_ringtone_silent)

                } else {
                    val ringtone = android.media.RingtoneManager.getRingtone(
                            preference.getContext(), android.net.Uri.parse(stringValue))

                    if (ringtone == null) {
                        // Clear the summary if there was a lookup error.
                        preference.setSummary(null)
                    } else {
                        // Set the summary to reflect the new ringtone display
                        // name.
                        val name = ringtone.getTitle(preference.getContext())
                        preference.setSummary(name)
                    }
                }

            } else {
                // For all other preferences, set the summary to the value's
                // simple string representation.
                preference.summary = stringValue
            }
            true
        }

        /**
         * Helper method to determine if the device has an extra-large screen. For
         * example, 10" tablets are extra-large.
         */
        private fun isXLargeTablet(context: android.content.Context): Boolean {
            return context.resources.configuration.screenLayout and android.content.res.Configuration.SCREENLAYOUT_SIZE_MASK >= android.content.res.Configuration.SCREENLAYOUT_SIZE_XLARGE
        }

        /**
         * Binds a preference's summary to its value. More specifically, when the
         * preference's value is changed, its summary (line of text below the
         * preference title) is updated to reflect the value. The summary is also
         * immediately updated upon calling this method. The exact display format is
         * dependent on the type of preference.

         * @see .sBindPreferenceSummaryToValueListener
         */
        private fun bindPreferenceSummaryToValue(preference: android.preference.Preference) {
            // Set the listener to watch for value changes.
            preference.onPreferenceChangeListener = com.gengqiquan.githubhelper.modules.setting.SettingsActivity.Companion.sBindPreferenceSummaryToValueListener

            // Trigger the listener immediately with the preference's
            // current value.
            com.gengqiquan.githubhelper.modules.setting.SettingsActivity.Companion.sBindPreferenceSummaryToValueListener.onPreferenceChange(preference,
                    android.preference.PreferenceManager
                            .getDefaultSharedPreferences(preference.context)
                            .getString(preference.key, ""))
        }
    }
}

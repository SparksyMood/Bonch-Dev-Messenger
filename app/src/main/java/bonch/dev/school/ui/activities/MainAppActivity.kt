package bonch.dev.school.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bonch.dev.school.R
import bonch.dev.school.ui.fragments.ChatFragment
import bonch.dev.school.ui.fragments.PasswordFragment
import bonch.dev.school.ui.fragments.ProfileFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class MainAppActivity : AppCompatActivity() {

    val fm = supportFragmentManager
    val chatFragment = ChatFragment()
    val profileFragment = ProfileFragment()
    val passwordFragment = PasswordFragment()

    private lateinit var  appBarConfiguration: AppBarConfiguration
    val toolbar: Toolbar = findViewById(R.id.toolbar)
    val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
    val navView: NavigationView = findViewById(R.id.nav_view)
    val navController = findNavController(R.id.nav_host_fragment)


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("BDM", "Starting to create MainAppActivity")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_app_ativity)

        setSupportActionBar(toolbar)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_profile, R.id.nav_chat
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        Log.d("BDM", "Starting to beginTransaction")
        fm.beginTransaction()
            .add(R.id.fragment_container, chatFragment)
            .commit()
        Log.d("BDM", "Ended beginTransaction")

        val recyclerView: RecyclerView = findViewById(R.id.rv)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    fun toProfileFragment(){
        fm.beginTransaction()
            .replace(R.id.fragment_container, profileFragment)
            .addToBackStack("fragment_chat")
            .commit()
    }

    fun toPasswordFragment() {
        passwordFragment.show(supportFragmentManager, "passwordFragment")
    }


    //fun toPasswordFragment(){
  //      fm.beginTransaction()
  //          .replace(R.id.fragment_container, passwordFragment)
  //          .addToBackStack("fragment_chat")
 //           .commit()
//    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}

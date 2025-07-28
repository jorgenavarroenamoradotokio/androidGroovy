package com.example.redurxmlgroovy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.redurxmlgroovy.fragments.ChatsFragment;
import com.example.redurxmlgroovy.fragments.EstadosFragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Iniciamos el ciclo de vida de la pantalla
        super.onCreate(savedInstanceState);

        // Indicamos el xml de la vista que vamos a cargar
        setContentView(R.layout.activity_main);

        // Activa diseño inmersivo a pantalla completa
        EdgeToEdge.enable(this);

        // Instanciamos la logica para el control del topAppBar
        controlTopAppBar(findViewById(R.id.topAppBar));

        // Instanciamos la logica para el control del menu lateral
        drawerLayout = findViewById(R.id.main);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, findViewById(R.id.topAppBar),
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Control de flujo del boton flotante
        controlBotonFlotante(findViewById(R.id.fab));

        // Control del flujo del menu inferior
        controlBottomNavigationView(findViewById(R.id.bottom_navigation));

        /*
         * Ajusta el padding para evitar que el contenido se esconda debajo de la barra de estado o navegación
         * Contiene los márgenes seguros del sistema (top, bottom, etc.)
         */

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void controlTopAppBar(@NonNull MaterialToolbar topAppBar) {
        topAppBar.setNavigationOnClickListener(v -> {
            // Accion al hacer click (por ejemplo abrir un menu despelgable)
        });

        // Opcional: Manejar clics de menu
        topAppBar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.menu_settings) {
                Toast.makeText(this, "Has seleccionado la lupa", Toast.LENGTH_SHORT).show();
                return true;
            } else if (item.getItemId() == R.id.menu_camera) {
                Toast.makeText(this, "Has seleccionado la camara", Toast.LENGTH_SHORT).show();
                return true;
            } else if (item.getItemId() == R.id.menu_settings) {
                Toast.makeText(this, "Has seleccionado menu flotante", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });
    }

    private void controlBotonFlotante(@NonNull FloatingActionButton fab) {
        // Acción al hacer clic
        fab.setOnClickListener(view -> {
            Toast.makeText(this, "FAB presionado", Toast.LENGTH_SHORT).show();
        });
    }

    private void controlBottomNavigationView(@NotNull BottomNavigationView bottomNav) {
        bottomNav.setOnItemSelectedListener(item -> {

            Fragment selectedFragment = null;

            if (item.getItemId() == R.id.nav_chats) {
                selectedFragment = new ChatsFragment();
            }else if (item.getItemId() == R.id.nav_estados){
                selectedFragment = new EstadosFragment();
            } else {
                Toast.makeText(this, "Opcion proximamente disponible", Toast.LENGTH_SHORT).show();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            }
            return true;
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.draw_menu_home) {
            Toast.makeText(this, "Inicio", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.draw_menu_settings) {
            Toast.makeText(this, "Configuración", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Opción no implementada", Toast.LENGTH_SHORT).show();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
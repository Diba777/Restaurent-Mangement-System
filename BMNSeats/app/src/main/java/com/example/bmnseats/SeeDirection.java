package com.example.bmnseats;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SeeDirection extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_direction);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //EditText Location_Edittext;
        //Location_Edittext=findViewById(R.id.seeDirection);

        // if ((str.contains("Mirpur")))
        // {
        LatLng Savar = new LatLng(23.850309, 90.261009);
        mMap.addMarker(new MarkerOptions()
                .position(Savar)
                .title("Savar")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Savar,12));

        LatLng Baipayl=new LatLng(23.947721, 90.275658);
        mMap.addMarker(new MarkerOptions()
                .position(Baipayl)
                .title("Baipayl")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Baipayl,12));

        LatLng Ashulia=new LatLng(23.900481, 90.327262);
        mMap.addMarker(new MarkerOptions()
                .position(Ashulia)
                .title("Ashulia")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Ashulia,12));

        LatLng Hemayetpur=new LatLng(23.792964, 90.271741);
        mMap.addMarker(new MarkerOptions()
                .position(Hemayetpur)
                .title("Hemayetpur")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.end_green)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Hemayetpur,12));
        // }
       /* else
        {
            Toast.makeText(this, "Outlet Not Found", Toast.LENGTH_SHORT).show();
        }*/

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},0);
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        else {

            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
        }

    }
}

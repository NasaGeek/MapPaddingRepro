package com.example.mapspaddingrepro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    var mrk: Marker? = null
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val pad = findViewById<View>(R.id.frame).paddingBottom
        mMap.setPadding(0, 0, 0, pad)
        mMap.setOnMapClickListener {
            mrk?.remove()
            // Marker should sit right in the crosshairs
            mrk = mMap.addMarker(MarkerOptions().position(it))

            // Calling this will result in the marker sitting above the crosshairs
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(it, 0f))
            // Both below calls work fine, marker's in the crosshairs
            //  mMap.moveCamera(CameraUpdateFactory.newLatLng(it))
            //  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(it, mMap.minZoomLevel))
        }
    }
}

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class MapsActivity : ComponentActivity(), OnMapReadyCallback, CoroutineScope by MainScope() {

    private lateinit var mapView: MapView
    private var googleMap: GoogleMap? = null
    private var marker: Marker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                MapViewContainer()
            }
        }

        mapView = MapView(this)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
    }

    @Composable
    fun MapViewContainer() {
        AndroidView({ mapView }) { mapView ->
            // Do nothing here
        }
    }

    // Extension function to await the GoogleMap instance
    @OptIn(ExperimentalCoroutinesApi::class)
    suspend fun MapView.awaitMap(): GoogleMap {
        return suspendCancellableCoroutine { cont ->
            getMapAsync { googleMap ->
                cont.resume(googleMap)
            }
        }
    }

    // In your onMapReady function
    override fun onMapReady(map: GoogleMap) {
        googleMap = map

        // Set the initial camera position
        val initialLatLng = LatLng(START_LATITUDE, START_LONGITUDE)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(initialLatLng, DEFAULT_ZOOM))

        // Add marker for the starting point
        marker = map.addMarker(MarkerOptions().position(initialLatLng).title("Start"))

        // Add marker for the destination point
        addDestinationMarker(DESTINATION_LATITUDE, DESTINATION_LONGITUDE)
    }

    private fun addDestinationMarker(latitude: Double, longitude: Double) {
        launch {
            val map = mapView.awaitMap()
            val destinationLatLng = LatLng(latitude, longitude)
            map.addMarker(MarkerOptions().position(destinationLatLng).title("Destination"))
        }
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
        cancel()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    companion object {
        private const val START_LATITUDE = 37.7749
        private const val START_LONGITUDE = -122.4194
        private const val DESTINATION_LATITUDE = 37.7749
        private const val DESTINATION_LONGITUDE = -122.4312
        private const val DEFAULT_ZOOM = 12f
    }
}


@Preview(showBackground = true)
@Composable
fun MapsActivityPreview() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Map Preview")
    }
}


@Composable
fun MapViewContainer(mapView: MapView) {
    AndroidView({ mapView }) { mapView ->
        // Do nothing here
    }
}

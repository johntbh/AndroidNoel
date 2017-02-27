package iut.paci.noelcommunity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import org.mapsforge.core.graphics.Bitmap;
import org.mapsforge.core.graphics.Color;
import org.mapsforge.core.graphics.Paint;
import org.mapsforge.core.graphics.Style;
import org.mapsforge.core.model.LatLong;
import org.mapsforge.core.model.Point;
import org.mapsforge.map.android.graphics.AndroidGraphicFactory;
import org.mapsforge.map.android.util.AndroidUtil;
import org.mapsforge.map.android.view.MapView;
import org.mapsforge.map.datastore.MapDataStore;
import org.mapsforge.map.layer.cache.TileCache;
import org.mapsforge.map.layer.overlay.Marker;
import org.mapsforge.map.layer.overlay.Polyline;
import org.mapsforge.map.layer.renderer.TileRendererLayer;
import org.mapsforge.map.reader.MapFile;
import org.mapsforge.map.rendertheme.InternalRenderTheme;

import java.io.File;
import java.util.List;

public class MapActivity extends AppCompatActivity {
    MapView mapView;
    TileCache tileCache;
    TileRendererLayer tileRendererLayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidGraphicFactory.createInstance(this.getApplication());
        mapView = new MapView(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            mapView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        this.setContentView(mapView);

        mapView.setClickable(true);
        mapView.getMapScaleBar().setVisible(true);
        mapView.setBuiltInZoomControls(true);
        mapView.setZoomLevelMin((byte) 10);
        mapView.setZoomLevelMax((byte) 20);
        tileCache = AndroidUtil.createTileCache(
                this,
                "mapcache",
                mapView.getModel().displayModel.getTileSize(), 1f,
                mapView.getModel().frameBufferModel.getOverdrawFactor()
        );
    }

    public void onStart() {
        super.onStart();
        File file = new File(Environment.getExternalStorageDirectory(),
                "/maps/paris.map");
        MapDataStore mapDataStore = new MapFile(file);
        tileRendererLayer = new TileRendererLayer(tileCache, mapDataStore,
                mapView.getModel().mapViewPosition,
                AndroidGraphicFactory.INSTANCE);
        tileRendererLayer.setXmlRenderTheme(InternalRenderTheme.OSMARENDER);
        mapView.getLayerManager().getLayers().add(tileRendererLayer);

        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        double lat = extra.getDouble("lat");
        double log = extra.getDouble("long");
        int district_id = extra.getInt("district_id");

        Log.d("district_id",Integer.toString(district_id));
        LatLong district = new LatLong(lat,log);

        this.drawMarker(district,R.drawable.ic_place_black_24dp);
        mapView.setCenter(district);
        mapView.setZoomLevel((byte) 12);

        Uri.Builder builder = new Uri.Builder();
        builder.scheme("http")
                .authority("iut.96.lt") // TODO: Input the good server
                .appendPath("community")
                .appendPath("getDistrict.php")
                .appendQueryParameter("id", Integer.toString(district_id));
        String urlString = builder.build().toString();

        new DistrictTask(MapActivity.this).execute(urlString);
    }

    public void onDestroy() {
        mapView.destroyAll();
        AndroidGraphicFactory.clearResourceMemoryCache();
        super.onDestroy();
    }

    public void drawMarker(LatLong geoPoint, int imageRessourceId) {
        this.drawMarker(geoPoint,imageRessourceId,"",null);
    }

    public void drawMarker(LatLong geoPoint, int imageRessourceId, String dialog_class, final Place p) {
        Drawable drawable = getResources().getDrawable(imageRessourceId);
        Bitmap bitmap = AndroidGraphicFactory.convertToBitmap(drawable);
        bitmap.scaleTo(130,130);
        Marker marker;
        if(p != null){
            marker = new Marker(geoPoint, bitmap, 0, -bitmap.getHeight() / 2) {
                @Override
                public boolean onTap(LatLong geoPoint, Point viewPos, Point tapPoint) {
                    if (contains(viewPos, tapPoint)) {
                        p.draw(MapActivity.this);
                        return true;
                    }
                    return false;
                }
            };
        }
        else{
            marker = new Marker(geoPoint, bitmap, 0, -bitmap.getHeight() / 2)
            {
                @Override
                public boolean onTap(LatLong geoPoint, Point viewPos, Point tapPoint){
                    if (contains(viewPos, tapPoint)) {
                        Toast.makeText(MapActivity.this,
                                "clicked marker",
                                Toast.LENGTH_SHORT).show();
                        return true;
                    }
                    return false;
                }
            };
        }
        mapView.getLayerManager().getLayers().add(marker);
    }

    public void drawPath(List<LatLong> path){
        Paint paint = AndroidGraphicFactory.INSTANCE.createPaint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(15);
        paint.setStyle(Style.STROKE);
        Polyline polyline = new Polyline(paint,
                AndroidGraphicFactory.INSTANCE);
        List<LatLong> coordinateList = polyline.getLatLongs();
        for(LatLong geoPoint : path)
            coordinateList.add(geoPoint);
        mapView.getLayerManager().getLayers().add(polyline);
    }

    public void drawDistrict(District district){
        for(Store s : district.stores){
            this.drawMarker(new LatLong(s.latitude,s.longitude),R.drawable.ic_local_florist_black_24dp,"store",s);
        }
        for(Deposite d : district.deposites){
            this.drawMarker(new LatLong(d.latitude,d.longitude),R.drawable.ic_delete_black_24dp,"deposite",d);
        }
    }
}


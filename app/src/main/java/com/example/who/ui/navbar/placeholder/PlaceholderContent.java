package com.example.who.ui.navbar.placeholder;

import android.graphics.drawable.Drawable;

import com.example.who.R;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {


    /**
     * An array of sample (placeholder) items.
     */
    public static final List<PlaceholderItem> ITEMS = new ArrayList<PlaceholderItem>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<String, PlaceholderItem>();

    private static final int COUNT = 8;

    static {
        // Add some sample items.
        for (int i = 0; i < COUNT; i++) {
            addItem(createPlaceholderItem(i));
        }
    }

    private static void addItem(PlaceholderItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static PlaceholderItem createPlaceholderItem(int position) {
        return new PlaceholderItem(String.valueOf(position), makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A placeholder item representing a piece of content.
     */
    public static class PlaceholderItem {

        //List of all Applications
        private final List<String> APPS = Arrays.asList("Planning","Carte","Webmail","Hippocampus","OnBoard","SVP","Intranet","Magazines");
        private final List<Integer> IMAGE = Arrays.asList(R.drawable.calendrier,R.drawable.carte_icon,R.drawable.webmail,R.drawable.hippocampus,R.drawable.onboard,R.drawable.svp,R.drawable.intranet,R.drawable.magazine);
        private List<String> URL = Arrays.asList("https://webmail.ec-nantes.fr","https://hippocampus.ec-nantes.fr","https://onboard.ec-nantes.fr","https://svp.ec-nantes.fr/","https://etudiant.ec-nantes.fr","https://vpn.ec-nantes.fr/sslvpn/portal.html#!/");
        public final String id;
        public final String content;
        public String url;
        public Integer image;

        public PlaceholderItem(String id, String details) {
            this.id = id;
            this.content = APPS.get(Integer.parseInt(id));
            this.image = IMAGE.get(Integer.valueOf(id));
            if (Integer.parseInt(id)>1){
                this.url = URL.get(Integer.valueOf(id)-2);
            }

        }

        @Override
        public String toString() {
            return content;
        }
    }
}
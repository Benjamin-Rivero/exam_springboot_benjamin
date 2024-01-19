package fr.benjamin.exam_springboot_benjamin.json_view;

public class JsonViews {

    public interface ListingListView{}

    public interface ListingShowView extends ListingListView,ModelView{}

    public interface ModelView{}

    public interface UserShowView extends ListingListView,ModelView{}

}

package github.retrofitplus.model;

import java.util.List;

import github.library.utils.INoProguard;


public class NewsRequest {


    public static class Res implements INoProguard {


        public String date;
        public List<StoriesBean> stories;
        public List<TopStoriesBean> top_stories;

        public static class StoriesBean implements INoProguard {
            public String ga_prefix;
            public int id;
            public String title;
            public int type;
            public boolean multipic;
            public List<String> images;
        }

        public static class TopStoriesBean implements INoProguard {
            public String ga_prefix;
            public int id;
            public String image;
            public String title;
            public int type;
        }
    }
}

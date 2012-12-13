(ns github_stories.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "github_stories"]
               (include-css "/css/bootstrap.css")]
              [:body
               [:div.container
                content]]))

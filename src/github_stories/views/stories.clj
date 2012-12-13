(ns github_stories.views.stories
  (:require [github_stories.views.common :as common]
            [noir.content.getting-started]
            [github_stories.models.story :as stories])
  (:use [noir.core :only [defpage defpartial]]))

(defpartial display-message [message]
            [:li (clojure.string/replace message #"\n" "</br>")])

(defpartial display-messages [user repo]
            [:ul (map display-message (stories/messages user repo))])

(defpartial display-repo [user repo]
            [:h1 user " " repo])

(defpage "/" []
         (common/layout
           [:p "Welcome"]))

(defpage "/:user/:repo" {:keys [user repo]}
         (common/layout
           [:body (display-repo user repo) (display-messages user repo)]))

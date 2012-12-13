(ns github_stories.views.stories
  (:require [github_stories.views.common :as common]
            [noir.content.getting-started]
            [github_stories.models.story :as stories])
  (:use [noir.core :only [defpage defpartial]]))

(defpartial display-message [message]
            [:p.lead.alert (clojure.string/replace message #"\n" "</br>")])

(defpartial display-messages [user repo]
            [:div.messages (map display-message (stories/messages user repo))])

(defpartial display-repo [user repo]
            [:h1 user " " repo])

(defpage "/" []
         (common/layout
           [:p.lead
            "To visit a repo's stories, go to /stories/:username/:repo"]))

(defpage "/stories/:user/:repo" {:keys [user repo]}
         (common/layout
           [:div.hero-unit (display-repo user repo) (display-messages user repo)]))

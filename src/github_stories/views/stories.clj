(ns github_stories.views.stories
  (:require [github_stories.views.common :as common]
            [noir.content.getting-started]
            [github_stories.models.story :as stories])
  (:use [noir.core :only [defpage defpartial]]))

(defpartial display-message [message]
            [:li message])

(defpage "/" []
         (common/layout
           [:p "Welcome"]))

(defpage "/:user/:repo" {:keys [user repo]}
         (common/layout
           [:ul (map display-message (stories/messages user repo))]))

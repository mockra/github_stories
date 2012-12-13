(ns github_stories.models.story
    (:require [noir.session :as session]
            [tentacles.repos :as repos]))

(defn commits [user repo]
  (map :commit (repos/commits user repo)))

(defn messages [user repo]
  (map :message (commits user repo)))

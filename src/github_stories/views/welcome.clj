(ns github_stories.views.welcome
  (:require [github_stories.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage]]))

(defpage "/welcome" []
         (common/layout
           [:p "Welcome to github_stories"]))

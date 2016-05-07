(ns frontendfi.views.app
  (:require [rum.core :as rum]
            [frontendfi.views.controls :refer [controls]]))

(rum/defc app []
          [:div.container
           (controls)])

#?(:cljs
   (defn mount! [mount-el]
     (rum/mount (app) mount-el)))
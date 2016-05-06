(ns frontendfi.views.app
  (:require [rum.core :as rum]))

(rum/defc app []
          [:div.container
           [:div.three-quarters-loader "Loading…"]
           [:p
            "HUEHUHUE"]
           [:p
            "Please run "
            [:code "lein figwheel"]
            " to start the ClojureScript compiler and reload the page."]
           [:p
            "See "
            [:a
             {:href "http://www.luminusweb.net/docs/clojurescript.md"}
             "ClojureScript"]
            " documentation for further details."]])

#?(:cljs
   (defn mount! [mount-el]
     (rum/mount (app) mount-el)))
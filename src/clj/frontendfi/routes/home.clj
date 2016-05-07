(ns frontendfi.routes.home
  (:require [frontendfi.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]

            [frontendfi.views :as views]))

(defn home-page []
  (layout/render views/main))

(defn devcards []
  (layout/render views/devcards))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/devcards" [] (devcards))
  (GET "/docs" [] (response/ok (-> "docs/docs.md" io/resource slurp))))


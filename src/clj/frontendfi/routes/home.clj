(ns frontendfi.routes.home
  (:require [frontendfi.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]

            [frontendfi.views :as home]))

(defn home-page []
  (layout/render home/main))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/docs" [] (response/ok (-> "docs/docs.md" io/resource slurp))))


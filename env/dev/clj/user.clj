(ns user
  (:require [mount.core :as mount]
            [frontendfi.figwheel :refer [start-fw stop-fw cljs]]
            frontendfi.core))

(defn start []
  (mount/start-without #'frontendfi.core/repl-server))

(defn stop []
  (mount/stop-except #'frontendfi.core/repl-server))

(defn restart []
  (stop)
  (start))



(ns user
  (:require [mount.core :as mount]
            [frontendfi.figwheel :refer [start-fw stop-fw cljs]]
            [clojure.tools.namespace.repl :refer [refresh]]
            frontendfi.core))

(defn start []
  (mount/start-without #'frontendfi.core/repl-server))

(defn stop []
  (mount/stop-except #'frontendfi.core/repl-server))

(defn restart []
  (stop)
  (refresh :after 'user/start))



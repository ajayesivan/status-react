(ns status-im.contexts.preview.quo.avatars.dapp-avatar
  (:require
    [quo.core :as quo]
    [quo.foundations.resources :as resources]
    [react-native.core :as rn]
    [status-im.contexts.preview.quo.preview :as preview]))

(def descriptor
  [{:type :boolean
    :key  :context?}
   {:type    :select
    :key     :size
    :options [{:key :size-32}
              {:key :size-64}]}])

(defn view
  []
  (let [[state set-state] (rn/use-state {:context? false
                                         :size     :size-32})]
    [preview/preview-container
     {:state      state
      :set-state  set-state
      :descriptor descriptor}
     [quo/dapp-avatar
      (assoc state
             :network-image (resources/get-network :ethereum)
             :image         (resources/get-dapp :coingecko))]]))

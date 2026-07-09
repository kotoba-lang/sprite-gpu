(ns kotoba.sprite-gpu
  "DEDUP NOTICE (2026-07-09, see CHANGELOG.md): this namespace used to carry its own copy of the
   sprite-primitive → GPU-quad converter. That copy diverged from kotoba-lang/webgpu's internal
   `kami.sprite-gpu` — which every live consumer (network-isekai, net-babiniku, and webgpu's own
   tests) actually depends on — and the divergence was a real bug: this copy's :rect branch treated
   :w/:h as full width/height instead of halving them to the half-extent convention `:size` uses
   elsewhere, so on-screen rects rendered ~2x too large on each axis vs. the Canvas2D reference
   (kami.sprite2d.cljs). kotoba-lang/webgpu fixed that bug in PR #10 (2026-07-08); this repo's copy
   never got the fix because nothing rebuilt it from source.

   So `kami.sprite-gpu` (kotoba-lang/webgpu) is now canonical, and this namespace is a thin
   re-export of it — same public API, always in sync, no more silent drift. If you're vendoring
   this repo standalone, requiring `kotoba.sprite-gpu` still works exactly as before; the
   implementation just lives one hop away now."
  (:require [kami.sprite-gpu :as impl]))

(def shapes "See kami.sprite-gpu/shapes." impl/shapes)
(def prim->quad "See kami.sprite-gpu/prim->quad." impl/prim->quad)
(def anim-quad "See kami.sprite-gpu/anim-quad." impl/anim-quad)
(def prims->quads "See kami.sprite-gpu/prims->quads." impl/prims->quads)
(def draw-ops->quads "See kami.sprite-gpu/draw-ops->quads." impl/draw-ops->quads)
(def pack-instances "See kami.sprite-gpu/pack-instances." impl/pack-instances)
(def sprite-sdf-shader "See kami.sprite-gpu/sprite-sdf-shader." impl/sprite-sdf-shader)

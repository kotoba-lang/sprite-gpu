# kotoba-lang/sprite-gpu

Kotoba runtime package for `kotoba.sprite-gpu`.

## Status: thin re-export (2026-07-09)

`src/kotoba/sprite_gpu.cljc` no longer carries its own implementation. It re-exports
[`kami.sprite-gpu`](https://github.com/kotoba-lang/webgpu/blob/main/src/kami/sprite_gpu.cljc)
from `kotoba-lang/webgpu`, which is the copy every live consumer (network-isekai,
net-babiniku) actually depends on, and the one that gets real bug fixes — e.g. PR #10
(2026-07-08) fixed `:rect` primitives rendering ~2x too large because `:w`/`:h` weren't
halved to match the half-extent `:size` convention. This repo's old standalone copy had
silently diverged and still had that bug. See CHANGELOG.md for the full rationale.

Requiring `kotoba.sprite-gpu` still works exactly as before — same public API, same
behaviour — it just delegates to the canonical implementation one hop away instead of
carrying a copy that can drift again.

## Test

```sh
clojure -M:test
```

# GWT-to-Angular Migration

Incremental (strangler-fig) migration of a legacy GWT (Google Web Toolkit) frontend to Angular, while preserving the existing backend and server-side controllers.

## Overview

This repo hosts both the new frontend and the existing backend during the migration period:

- **`/frontend`** — New Angular (v21) application, using AG Grid for data tables and Angular Material for UI components. Connects to the existing backend endpoints.
- **`/backend`** — Existing server-side application and controllers (unchanged). Backend endpoints are being audited to determine whether they expose REST/JSON or GWT-RPC, which determines if a REST facade/adapter layer is needed before Angular integration.

## Migration Strategy

- **Approach:** Strangler-fig pattern — screens are migrated incrementally from GWT to Angular rather than a big-bang rewrite.
- **Coexistence:** GWT and Angular run side by side during the transition, via a reverse proxy or an iframe-based shell (routing decided per environment).
- **Backend:** No backend rewrite. Where controllers only expose GWT-RPC, a thin REST/JSON adapter layer is introduced so Angular can consume them without touching core business logic.

## Tech Stack

| Layer      | Technology                          |
|------------|--------------------------------------|
| Frontend   | Angular 21, Angular Material, AG Grid |
| Backend    | Existing stack (unchanged)          |
| Legacy UI  | GWT (being phased out)              |

## Getting Started

### Frontend
```bash
cd frontend
npm install
npm start
```

### Backend
```bash
cd backend
# existing build/run commands
```

## Status

🚧 Active migration in progress. Screens are being moved from GWT to Angular incrementally; see project board / issues for current progress.

## Contributing

Pull requests should target a single screen or module migration where possible, to keep changes reviewable and reduce coexistence risk.
